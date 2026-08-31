#include <bits/stdc++.h>
using namespace std;
const long long MOD = (long long)1e9 + 7;
const long double PI = 3.141592653589793238462643383279502884197;
priority_queue<int, vector<int>, greater<int> > pq;
vector<int> v;
char s[300001];
int main() {
  int n;
  scanf("%d", &n);
  scanf("%s", s);
  int mav = s[0], mavi = 0;
  for (int i = 1; i < n; i++) {
    if (s[i] < mav) return !printf("YES\n%d %d", mavi + 1, i + 1);
    if (mav < s[i]) {
      mav = s[i];
      mavi = i;
    }
  }
  printf("NO");
}
