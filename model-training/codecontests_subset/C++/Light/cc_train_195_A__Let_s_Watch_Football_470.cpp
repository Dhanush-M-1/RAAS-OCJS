#include <bits/stdc++.h>
using namespace std;
bool debug = false;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  k = (a - b) * c;
  printf("%d\n", k % b == 0 ? k / b : k / b + 1);
  return 0;
}
