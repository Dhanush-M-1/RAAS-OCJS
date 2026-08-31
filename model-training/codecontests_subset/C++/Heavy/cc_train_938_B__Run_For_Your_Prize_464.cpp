#include <bits/stdc++.h>
using namespace std;
long long isvowel(char c) {
  if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y')
    return 1;
  else
    return 0;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long i, j;
  long long n;
  cin >> n;
  long long s = 1000000;
  vector<long long> v(s + 1);
  for (i = 1; i <= n; i++) {
    long long a;
    cin >> a;
    v[a] = 1;
  }
  long long tot = 0;
  long long me = 1, he = 1000000;
  long long time = 0;
  while (1) {
    time++;
    me++;
    if (v[me] == 1) tot++;
    if (tot == n || me == he - 1) break;
    he--;
    if (v[he] == 1) tot++;
    if (tot == n || me == he - 1) break;
  }
  cout << time << endl;
}
