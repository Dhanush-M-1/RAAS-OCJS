#include <bits/stdc++.h>
using namespace std;
struct node {
  int a, b, t;
  int index;
  node() {}
  node(int _a, int _b, int _t, int _index) {
    a = _a;
    b = _b;
    t = _t;
    index = _index;
  }
  bool operator<(const struct node &nd) const { return t < nd.t; }
  bool operator>(const struct node &nd) const { return t > nd.t; }
};
vector<node> all, alice, bob, none;
priority_queue<node> taken;
int all_size, alice_size, bob_size, none_size;
priority_queue<node, vector<node>, greater<node> > freee;
int minAllCount(int n, int m, int k) {
  for (int i = 0; i <= all_size; i++) {
    if (alice_size + i >= k && bob_size + i >= k &&
        i + max(0, k - i) + max(0, k - i) <= m &&
        alice_size + bob_size + none_size + i >= m) {
      return i;
    }
  }
  return n + 1;
}
int maxAllCount(int n, int m, int k) {
  for (int i = all_size; i >= 0; i--) {
    if (alice_size + i >= k && bob_size + i >= k &&
        i + max(0, k - i) + max(0, k - i) <= m &&
        alice_size + bob_size + none_size + i >= m) {
      return i;
    }
  }
  return -1;
}
bool isPossible(int n, int m, int k) {
  if (all_size >= k) {
    return true;
  }
  int minFromAlice = k - all_size;
  int minFromBob = k - all_size;
  if (minFromAlice > alice_size || minFromBob > bob_size) {
    return false;
  } else if (all_size + minFromAlice + minFromBob > m) {
    return false;
  }
  return true;
}
vector<int> finalTakenBooks;
void updateResult(int cntAll, int k, int m) {
  for (int i = 0; i < cntAll; i++) {
    finalTakenBooks.push_back(all[i].index);
  }
  for (int i = 0; i < k - cntAll; i++) {
    if (i < alice_size) finalTakenBooks.push_back(alice[i].index);
    if (i < bob_size) finalTakenBooks.push_back(bob[i].index);
  }
  while (!taken.empty()) {
    node nd = taken.top();
    taken.pop();
    finalTakenBooks.push_back(nd.index);
  }
}
pair<int, int> getOptimalResult(int n, int m, int k, int optimal = -1) {
  int l = minAllCount(n, m, k);
  int h = maxAllCount(n, m, k);
  int sm = 0;
  for (int i = 0; i < l; i++) {
    sm += all[i].t;
  }
  assert(k - l <= alice_size && k - l <= bob_size);
  for (int i = 0; i < k - l; i++) {
    sm += alice[i].t;
    sm += bob[i].t;
  }
  while (!freee.empty()) freee.pop();
  while (!taken.empty()) taken.pop();
  for (int i = max(0, k - l); i < alice_size; i++) {
    freee.push(alice[i]);
  }
  for (int i = max(0, k - l); i < bob_size; i++) {
    freee.push(bob[i]);
  }
  for (int i = 0; i < none_size; i++) {
    freee.push(none[i]);
  }
  int optimalcnt = -1, optimalTime = INT_MAX;
  for (int cnt = l; cnt <= h; cnt++) {
    int otherNeeded = (m - cnt - 2 * max(0, k - cnt));
    while (otherNeeded > (int)taken.size()) {
      node nd = freee.top();
      freee.pop();
      sm += nd.t;
      taken.push(nd);
    }
    while (otherNeeded >= 0 && otherNeeded < (int)taken.size()) {
      node nd = taken.top();
      taken.pop();
      sm -= nd.t;
      freee.push(nd);
    }
    while (!taken.empty() && !freee.empty() && freee.top().t < taken.top().t) {
      node freeTop = freee.top();
      freee.pop();
      node takenTop = taken.top();
      taken.pop();
      freee.push(takenTop);
      taken.push(freeTop);
      sm -= takenTop.t;
      sm += freeTop.t;
    }
    if (sm < optimalTime && otherNeeded == taken.size()) {
      optimalTime = sm;
      optimalcnt = cnt;
    }
    if (cnt == optimal) {
      updateResult(cnt, k, m);
      return {optimalTime, cnt};
    }
    if (cnt < h) {
      sm += all[cnt].t;
    }
    if (k - cnt > 0) {
      sm -= alice[k - cnt - 1].t;
      sm -= bob[k - cnt - 1].t;
      freee.push(alice[k - cnt - 1]);
      freee.push(bob[k - cnt - 1]);
    }
  }
  return {optimalTime, optimalcnt};
}
void solve(int n, int m, int k) {
  all_size = all.size();
  alice_size = alice.size();
  bob_size = bob.size();
  none_size = none.size();
  assert(all_size + alice_size + bob_size + none_size == n);
  if (!isPossible(n, m, k) || minAllCount(n, m, k) > maxAllCount(n, m, k)) {
    puts("-1");
    return;
  }
  sort(all.begin(), all.end());
  sort(alice.begin(), alice.end());
  sort(bob.begin(), bob.end());
  sort(none.begin(), none.end());
  pair<int, int> result = getOptimalResult(n, m, k);
  result = getOptimalResult(n, m, k, result.second);
  printf("%d\n", result.first);
  for (int i = 0; i < finalTakenBooks.size(); i++) {
    if (i) printf(" ");
    printf("%d", finalTakenBooks[i]);
  }
  puts("");
}
int main() {
  int n, m, k, i;
  scanf("%d %d %d", &n, &m, &k);
  node nd;
  int a, b, t;
  for (i = 0; i < n; i++) {
    scanf("%d %d %d", &t, &a, &b);
    nd = node(a, b, t, i + 1);
    if (a && b) {
      all.push_back(nd);
    } else if (a) {
      alice.push_back(nd);
    } else if (b) {
      bob.push_back(nd);
    } else {
      none.push_back(nd);
    }
  }
  solve(n, m, k);
  return 0;
}
