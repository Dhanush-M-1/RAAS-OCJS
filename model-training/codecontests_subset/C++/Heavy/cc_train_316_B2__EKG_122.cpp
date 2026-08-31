#include <bits/stdc++.h>
using namespace std;
long long a[1002];
int n, k;
long long queues[1002];
vector<long long> lens;
set<long long> lensSet;
int lensCount[1002];
vector<long long> nils;
set<long long> results;
int main() {
  scanf("%d %d", &n, &k);
  int t;
  for (long long i = 1; i <= n; ++i) {
    scanf("%d", &t);
    a[i] = t;
    queues[t] = i;
    if (t == 0) nils.push_back(i);
  }
  long long prev = 0;
  {
    long long cur = k;
    while (a[cur]) {
      prev += 1;
      cur = a[cur];
    }
  }
  for (vector<long long>::iterator it = nils.begin(); it != nils.end(); it++) {
    long long len = 1;
    long long cur = *it;
    bool ok = cur != k;
    while (queues[cur]) {
      if (cur == k) {
        ok = false;
        break;
      }
      len += 1;
      cur = queues[cur];
    }
    if (ok && cur != k) {
      lens.push_back(len);
      lensSet.insert(len);
      lensCount[len] += 1;
    }
  }
  results.insert(0);
  for (set<long long>::iterator it = lensSet.begin(); it != lensSet.end();
       it++) {
    set<long long> newRes;
    newRes.insert(*it);
    int nn = lensCount[*it];
    for (int e = 1; e <= nn; ++e) {
      for (set<long long>::iterator jt = results.begin(); jt != results.end();
           jt++) {
        newRes.insert(*jt + (*it) * e);
      }
    }
    results.insert(newRes.begin(), newRes.end());
  }
  for (set<long long>::iterator it = results.begin(); it != results.end();
       it++) {
    cout << *it + prev + 1 << endl;
  }
  return 0;
}
