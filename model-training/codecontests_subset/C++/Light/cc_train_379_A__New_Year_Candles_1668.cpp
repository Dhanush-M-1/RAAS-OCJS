#include <bits/stdc++.h>
using namespace std;
int arr[1000003];
int maximo[1000004];
int bonus[1000006];
int marca[100000];
void solve() {
  int a, b;
  cin >> a >> b;
  int sum = a + (a / b);
  int cuantos = a / b + (a % b);
  while (cuantos >= b) {
    sum += cuantos / b;
    cuantos = cuantos / b + (cuantos % b);
  }
  cout << sum << endl;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  solve();
  return 0;
}
