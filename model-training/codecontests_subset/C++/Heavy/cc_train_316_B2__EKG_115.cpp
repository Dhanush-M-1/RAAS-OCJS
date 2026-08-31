#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, j;
  int temp, ct;
  int base;
  long long int val;
  bool smart;
  cin >> n >> x;
  vector<int> next(n + 1, 0);
  vector<int> inDeg(n + 1, 0);
  for (int i = 1; i <= n; i++) {
    cin >> temp;
    if (temp != 0) {
      next[i] = temp;
      inDeg[temp]++;
    }
  }
  vector<int> sums;
  for (int i = 1; i <= n; i++)
    if (inDeg[i] == 0) {
      j = i;
      ct = 1;
      smart = false;
      if (j == x) smart = true;
      while (next[j] != 0) {
        j = next[j];
        if (j == x) {
          smart = true;
          break;
        }
        ct++;
      }
      if (!smart) sums.push_back(ct);
    }
  j = x;
  base = 1;
  while (next[j] != 0) {
    j = next[j];
    base++;
  }
  set<long long int> pos;
  pos.insert(0);
  stack<long long int> toAdd;
  for (int i = 0; i < sums.size(); i++) {
    val = (long long int)sums[i];
    for (auto it = pos.begin(); it != pos.end(); it++) toAdd.push(*it + val);
    pos.insert(val);
    while (!toAdd.empty()) {
      pos.insert(toAdd.top());
      toAdd.pop();
    }
  }
  for (auto it = pos.begin(); it != pos.end(); it++) cout << *it + base << endl;
}
