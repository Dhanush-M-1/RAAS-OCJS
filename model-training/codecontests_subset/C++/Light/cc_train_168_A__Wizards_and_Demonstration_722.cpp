#include <bits/stdc++.h>
using namespace std;
double y;
double n, x;
int resp;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> x >> y;
  resp = ceil((y * n) / 100.0) - x;
  if (resp > 0) {
    cout << resp << "\n";
  } else {
    cout << "0\n";
  }
  return 0;
}
