#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  cin >> a >> b >> c;
  int t = a * c;
  if (t % b == 0)
    cout << t / b - c;
  else
    cout << t / b - c + 1;
  a++;
}
