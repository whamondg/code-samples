defmodule Metex do
  def get_temperature(locations) when is_list(locations) do
    Enum.reduce locations, %{}, fn location, results ->
      Map.put(results, location, get_temperature(location)) 
    end
  end

  def get_temperature(location) do
    {:ok, pid} = Metex.Worker.start_link
    Metex.Worker.get_temperature(pid, location)
  end
end
