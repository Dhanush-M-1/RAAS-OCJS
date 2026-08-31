#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, a, b, c;
  cin >> n >> a >> b >> c;
  int count = 0;
  for (int i = 0; i < a + 1; i++)
    for (int j = 0; j < b + 1; j++)
      if (i % 2 == 0 && (n - (i / 2 + j)) % 2 == 0 &&
          (n - (i / 2 + j)) / 2 >= 0 && (n - (i / 2 + j)) / 2 <= c)
        count++;
  cout << count << endl;
  return 0;
}
