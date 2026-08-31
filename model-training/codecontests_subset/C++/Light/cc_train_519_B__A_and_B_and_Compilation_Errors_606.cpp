#include <bits/stdc++.h>
using namespace std;
const long long oo = 1000000000000000000;
const int N = 100005;
int main() {
  int n, x;
  scanf("%d", &n);
  multiset<int> a, b;
  for (int i = 0; i < int(n); i++) {
    scanf("%d", &x);
    a.insert(x);
  }
  for (int i = 0; i < int(n - 1); i++) {
    scanf("%d", &x);
    b.insert(x);
    a.erase(a.find(x));
  }
  printf("%d\n", *a.begin());
  a.clear();
  swap(a, b);
  for (int i = 0; i < int(n - 2); i++) {
    scanf("%d", &x);
    b.insert(x);
    a.erase(a.find(x));
  }
  printf("%d\n", *a.begin());
  return 0;
}
