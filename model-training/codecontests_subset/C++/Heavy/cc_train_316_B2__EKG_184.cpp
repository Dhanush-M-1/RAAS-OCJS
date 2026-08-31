#include <bits/stdc++.h>
using namespace std;
int sudah[444];
int depan[50000];
int blkg[50000];
int knap[4000];
int main() {
  int n, x;
  cin >> n >> x;
  --x;
  for (int(i) = 0; (i) < (n); ++(i)) cin >> depan[i];
  for (int(i) = 0; (i) < (n); ++(i)) blkg[i] = -1;
  for (int(i) = 0; (i) < (n); ++(i)) {
    depan[i] -= 1;
    if (depan[i] >= 0) blkg[depan[i]] = i;
  }
  vector<int> sequences;
  for (int(i) = 0; (i) < (n); ++(i))
    if (blkg[i] == -1) {
      int len = 1;
      int ok = (i != x);
      int j = i;
      while (depan[j] != -1) {
        ++len;
        j = depan[j];
        if (j == x) ok = 0;
      }
      if (!ok) continue;
      sequences.push_back(len);
    }
  int init_len = 1;
  int p = x;
  while (depan[p] != -1) {
    p = depan[p];
    init_len += 1;
  }
  knap[init_len] = 1;
  for (typeof((sequences).begin()) it = (sequences).begin();
       it != (sequences).end(); it++) {
    for (int jum = n + 1; jum >= 1; --jum) {
      knap[jum + *it] |= knap[jum];
    }
  }
  for (int i = 1; i <= n; ++i)
    if (knap[i]) cout << i << endl;
}
