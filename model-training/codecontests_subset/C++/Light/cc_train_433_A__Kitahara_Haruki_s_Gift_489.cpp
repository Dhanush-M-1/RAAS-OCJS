#include <bits/stdc++.h>
using namespace std;
int main() {
  int N, sot = 0, dvus = 0, r;
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> r;
    if (r == 100)
      sot++;
    else
      dvus++;
  }
  if (sot % 2) cout << "NO";
  if (!(sot % 2) && !(dvus % 2)) cout << "YES";
  if (!(sot % 2) && (dvus % 2)) {
    if (sot < 2)
      cout << "NO";
    else
      cout << "YES";
  }
  return 0;
}
