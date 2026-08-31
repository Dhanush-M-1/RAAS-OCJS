#include <bits/stdc++.h>
using namespace std;
long long int arr[100005], fx[100005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  long long int d;
  cin >> n >> d;
  long long int cart = 0;
  long long int a = 0;
  arr[0] = 0;
  for (int i = 1; i <= n; i++) {
    int c;
    cin >> c;
    arr[i] = arr[i - 1] + c;
    if (c == 0) {
      if (arr[i] < 0) {
        a += -arr[i];
        arr[i] = 0;
      }
    }
    fx[i] = a;
    if (arr[i] > d) {
      cout << "-1";
      return 0;
    }
  }
  for (int i = n - 1; i > 0; i--) {
    if (fx[i] != fx[i + 1]) {
      if (arr[i] + (fx[i + 1] - fx[i]) <= d) {
        arr[i] += fx[i + 1] - fx[i];
        fx[i] = fx[i + 1];
      }
    }
  }
  long long int check = 0;
  long long int cc = 0;
  for (int i = 1; i <= n; i++) {
    if (check != fx[i]) {
      check = fx[i];
      cc++;
    }
  }
  cout << cc;
  return 0;
}
