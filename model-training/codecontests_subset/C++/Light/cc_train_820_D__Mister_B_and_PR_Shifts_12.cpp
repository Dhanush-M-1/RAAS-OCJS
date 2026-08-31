#include <bits/stdc++.h>
using namespace std;
void addmod(int &a, long long b) {
  a = (a + b);
  if (a >= 1000000007) a -= 1000000007;
}
void mulmod(int &a, long long b) { a = (a * b) % 1000000007; }
template <class T>
bool domin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <class T>
bool domax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
int gi() {
  int a;
  scanf("%d", &a);
  return a;
}
long long gll() {
  long long a;
  scanf("%lld", &a);
  return a;
}
int main() {
  int n = gi(), ix = 0;
  vector<int> a(n + 1);
  long long ans = 0, nr = 0, ni = 0, mans = LLONG_MAX;
  vector<int> sr(n + 5, 0);
  for (auto i = 1; i <= n; i++) {
    a[i] = gi();
    ans += abs(i - a[i]);
    if (a[i] <= i) {
      ni++;
    } else {
      nr++;
      sr[a[i] - i]++;
    }
  }
  mans = ans;
  for (int i = n, j = 1; i > 1; i--, j++) {
    ni--;
    long long tans = ans - abs(a[i] - n);
    tans += a[i] - 1;
    tans += (ni - nr);
    if (mans > tans) {
      mans = tans;
      ix = j;
    }
    ans = tans;
    nr++;
    int k = j + a[i] - 1;
    if (k <= n) sr[k]++;
    nr -= sr[j];
    ni += sr[j];
  }
  cout << mans << " " << ix << endl;
  return 0;
}
