def check?(x, y, queens)
  !queens.each_with_index.any? {|qx, qy|
    y == qy ||
    x == qx ||
    (qx - qy) == (x - y) ||
    (qx + qy) == (x + y)
  }
end

def queen2(n, x = 0, queens = [])
  return queens if queens.size >= n

  if x < n
    if check?(x, queens.size, queens)
      queens.push(x)
      queen2(n, 0, queens)
    else
      x += 1
      while x >= n
        x = queens.pop
        x += 1
      end
      queen2(n, x, queens)
    end
  end
end

p queen2(4)

# def queen(n)
#   queens = []
#   while queens.size < n
#     x = 0
#     while x < n
#       if check?(x, queens.size, queens)
#         queens.push(x)
#         break
#       else
#         x += 1
#         while x >= n
#           x = queens.pop
#           x += 1
#         end
#       end
#     end
#   end

#   queens
# end

# def display_queen(n)
#   queens = queen2(n)
#   result = []
#   n.times do |x|
#     row = []
#     n.times do |y|
#       row <<
#         if queens[y] == x
#           'Q'
#         else
#           '.'
#         end
#     end
#     result[x] = row.join(' ')
#   end
#   result.join("\n")
# end

# puts display_queen(8)
