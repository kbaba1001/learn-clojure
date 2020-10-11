def hanoi(n, m = 1, arr = [(1..n).to_a.reverse, [], []])
  puts "A: #{arr[0]}\nB: #{arr[1]}\nC: #{arr[2]}\n------------"
  if arr[2].length >= n
    return
  end

  # ((m & (m-1)) % 3) 番目の棒にある円盤を (((m| (m-1)) +1) %3) 番目の棒に移動する
  tmp = arr[((m & (m - 1)) % 3)].pop
  if !tmp.nil?
    arr[(((m | (m - 1)) + 1) % 3)].push(tmp)
  end
  hanoi(n, m + 1, arr)
end

hanoi(3)
