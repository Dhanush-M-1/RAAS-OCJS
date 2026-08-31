#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, w, one = 0, two = 0;
  cin >> n;
  while (n--) {
    cin >> w;
    if (w == 100)
      one++;
    else
      two++;
  }
  int weight = (one * 100) + (two * 200);
  if (weight % 200 != 0)
    cout << "NO";
  else {
    int half = weight / 2;
    bool find = 0;
    for (int i = 0; i <= two; i++)
      if (200 * i <= half && half - 200 * i <= 100 * one) find = 1;
    if (find)
      cout << "YES";
    else
      cout << "NO";
  }
  return 0;
}
