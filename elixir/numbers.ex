defmodule NumberUtil do
  def sum([]), do: 0
  def sum([head|tail]), do: head + sum(tail)  
  def sum(num) when is_number(num), do: num
end



