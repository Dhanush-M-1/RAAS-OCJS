class TrieNode:
  limit = 0
  min_cost = 32 * 200000
  
  def __init__(self):
    self.nodes = [None, None]
    self.count = 0
    self.cost = 0
    
  def add(self, word, pos = 0):
    delta = len(word) - pos
    self.count += 1
    self.cost += delta
    if self.count == TrieNode.limit:
      TrieNode.min_cost = min(self.cost, TrieNode.min_cost)
    if delta:  
      if not self.nodes[word[pos]]:
        self.nodes[word[pos]] = TrieNode()
      self.nodes[word[pos]].add(word, pos + 1)

def convert(word):
  return list(map(int, format(word, 'b')))

n, TrieNode.limit = map(int, input().split())
x = sorted(map(int, input().split()))
root = TrieNode()
for w in x:
  root.add(convert(w))
print(TrieNode.min_cost)  