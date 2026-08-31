#include <bits/stdc++.h>
using namespace std;
long long x[1000100];
long long n;
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long a;
    cin >> a;
    x[a]++;
  }
  long long st1 = 1;
  long long st2 = 1000000;
  long long tot = 0;
  long long sol = 0;
  while (st2 >= st1) {
    st2--;
    st1++;
    sol++;
    tot += x[st1];
    tot += x[st2];
    if (tot >= n) break;
  }
  cout << sol << endl;
}
