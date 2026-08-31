#include <bits/stdc++.h>
using namespace std;
multiset<int> b;
multiset<int>::iterator it;
int sia = 0;
long long ansa = 0, ansb = 0;
stack<int> sta;
int k[1000005];
int main() {
  int n, ansk = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", k + i);
    if (k[i] > i) {
      b.insert(k[i] - i);
      ansb += k[i] - i;
    } else {
      ++sia;
      ansa += i - k[i];
    }
  }
  long long mi = ansa + ansb;
  int co = 1;
  for (int i = n; i > 1; --i) {
    ansb -= b.size();
    ansa += sia;
    int t = b.size();
    it = b.upper_bound(co);
    b.erase(b.begin(), it);
    t -= b.size();
    sia += t;
    if (k[i] > n + 1) {
      b.erase(b.find(k[i] - n - 1 + co));
      ansb -= k[i] - n - 1;
    } else {
      --sia;
      ansa -= n + 1 - k[i];
    }
    if (k[i] > 1) {
      b.insert(k[i] - 1 + co);
      ansb += k[i] - 1;
    } else {
      ++sia;
      ansa += 1 - k[i];
    }
    ++co;
    if (mi > ansa + ansb) {
      mi = ansa + ansb;
      ansk = co - 1;
    }
  }
  cout << mi << ' ' << ansk << endl;
  return 0;
}
