#include <bits/stdc++.h>
double EPS = 1e-9;
int INF = 1000000005;
long long INFF = 1000000000000000005LL;
double PI = acos(-1);
int dirx[8] = {-1, 0, 0, 1, -1, -1, 1, 1};
int diry[8] = {0, 1, -1, 0, -1, 1, -1, 1};
using namespace std;
int main() {
  int n;
  cin >> n;
  string second;
  cin >> second;
  int cnta = 0, cnti = 0, cntf = 0;
  for (int i = 0; i < n; i++) {
    if (second[i] == 'A') {
      cnta++;
    } else if (second[i] == 'I') {
      cnti++;
    } else
      cntf++;
  }
  if (cnti == 0 && cnta >= 1)
    cout << cnta;
  else if (cnti == 1)
    cout << cnti;
  else
    cout << 0;
  return 0;
}
