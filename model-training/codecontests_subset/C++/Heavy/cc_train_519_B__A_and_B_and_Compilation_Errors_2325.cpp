#include <bits/stdc++.h>
using namespace std;
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
int main(int argc, char const *argv[]) {
  cin.sync_with_stdio(0);
  long long int n, x;
  scanf("%lld", &n);
  multiset<long long int> st, st1;
  for (int i = 0; i < n; ++i) {
    scanf("%lld", &x);
    st.insert(x);
  }
  st1.insert(st.begin(), st.end());
  for (int i = 0; i < n - 1; ++i) {
    scanf("%lld", &x);
    st.erase(st.find(x));
  }
  printf("%lld\n", (*st.begin()));
  st1.erase(st1.find(*st.begin()));
  for (int i = 0; i < n - 2; ++i) {
    scanf("%lld", &x);
    st1.erase(st1.find(x));
  }
  printf("%lld\n", (*st1.begin()));
}
