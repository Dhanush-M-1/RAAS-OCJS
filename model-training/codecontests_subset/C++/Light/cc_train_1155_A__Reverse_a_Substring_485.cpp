#include <bits/stdc++.h>
using namespace std;
short int dx[4] = {0, 0, 1, -1};
short int dy[4] = {1, -1, 0, 0};
short int dxx[8] = {0, 0, 1, -1, 1, -1, 1, -1};
short int dyy[8] = {1, -1, 0, 0, 1, -1, -1, 1};
long long int x[100000];
int main() {
  cin >> x[0];
  string y;
  cin >> y;
  long long int a = 0, b, c, d, e;
  for (int i = 0; i < y.length() - 1; i++)
    if (y[i] <= y[i + 1])
      a++;
    else {
      cout << "YES" << endl << i + 1 << ' ' << i + 2;
      return 0;
    }
  cout << "NO";
}
