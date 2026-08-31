#include <bits/stdc++.h>
using namespace std;
vector<int> arr1, arr2, rpt, sum1, sum2;
int main() {
  double n, a, b, c;
  cin >> n >> a >> b >> c;
  int r = 0;
  n *= 2;
  for (int i = 0; i < c + 1; i++)
    for (int j = 0; j < b + 1; j++)
      if (n - 4 * i - 2 * j >= 0 && n - 4 * i - 2 * j <= a) r++;
  cout << r << endl;
}
