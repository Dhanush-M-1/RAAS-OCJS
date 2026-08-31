#include <bits/stdc++.h>
using namespace std;
struct OrderSet {
  struct Trie {
    int cnt;
    int next[2];
    Trie() {
      memset(next, -1, sizeof(next));
      cnt = 0;
    }
  };
  vector<Trie*> trie;
  OrderSet() {
    auto u = new Trie();
    trie.push_back(u);
  }
  bool find(int first) {
    int cur = 0;
    for (int i = 30; i >= 0; i--) {
      auto u = ((first >> i) & 1);
      if (trie[cur]->next[u] == -1)
        return 0;
      else
        cur = trie[cur]->next[u];
    }
    return 1;
  }
  void insert(int first) {
    int cur = 0;
    trie[cur]->cnt++;
    for (int i = 30; i >= 0; i--) {
      auto u = ((first >> i) & 1);
      if (trie[cur]->next[u] == -1) {
        auto newTrie = new Trie();
        trie.push_back(newTrie);
        trie[cur]->next[u] = trie.size() - 1;
        cur = trie[cur]->next[u];
      } else {
        cur = trie[cur]->next[u];
      }
      trie[cur]->cnt++;
    }
  }
  void deletee(int first) {
    int cur = 0;
    trie[cur]->cnt--;
    for (int i = 30; i >= 0; i--) {
      auto u = ((first >> i) & 1);
      int temp = trie[cur]->next[u];
      if (trie[temp]->cnt == 1) trie[cur]->next[u] = -1;
      cur = temp;
      trie[cur]->cnt--;
    }
  }
  int order_of_key(int first) {
    int cur = 0;
    int res = 0;
    for (int i = 30; i >= 0; i--) {
      auto u = ((first >> i) & 1);
      if (u == 1 && trie[cur]->next[0] != -1) {
        int temp = trie[cur]->next[0];
        res += trie[temp]->cnt;
      }
      if (trie[cur]->next[u] == -1) return res;
      cur = trie[cur]->next[u];
    }
    return res;
  }
  int find_by_order(int k) {
    int cur = 0;
    int res = 0;
    if (trie[cur]->cnt < k) return -1;
    for (int i = 30; i >= 0; i--) {
      int temp = trie[cur]->next[0];
      if (temp == -1) {
        cur = trie[cur]->next[1];
        res += (1 << i);
        continue;
      }
      if (trie[temp]->cnt < k) {
        k -= trie[temp]->cnt;
        cur = trie[cur]->next[1];
        res += (1 << i);
      } else {
        cur = trie[cur]->next[0];
      }
    }
    return res;
  }
} os;
pair<int, int> a[200005];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].first;
  }
  for (int i = 1; i <= n; i++) {
    cin >> a[i].second;
    a[i].second += 2e8;
  }
  sort(a + 1, a + n + 1);
  long long ans = 0;
  map<int, int> cnt;
  for (int i = 1; i <= n; i++) {
    ans += 1LL * (os.order_of_key(a[i].second) + cnt[a[i].second]) * a[i].first;
    os.insert(a[i].second);
    cnt[a[i].second]++;
  }
  os = OrderSet();
  for (int i = n; i >= 1; i--) {
    ans -= 1LL * (n - i - os.order_of_key(a[i].second)) * a[i].first;
    os.insert(a[i].second);
  }
  cout << ans;
  return 0;
}
