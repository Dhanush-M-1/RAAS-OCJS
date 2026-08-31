#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x, y;
  cin >> n >> x >> y;
  long long int req = ceil(y * n / 100.0);
  if (req > x)
    cout << req - x << endl;
  else
    cout << "0\n";
}
