defmodule App.CLI do
  def main(args \\ []) do
    args
    |> parse_args
    |> view
  end

  defp parse_args(args) do
      args
      |> OptionParser.parse(switches: [a: :boolean])
  end

  defp view({opts, args, invalid}) do
    IO.puts inspect opts
    IO.puts inspect args
    IO.puts Enum.join(args, ", ")
    IO.puts inspect invalid
  end

  defp response({opts, word}) do
    if opts[:upcase], do: String.upcase(word), else: word
  end
end
