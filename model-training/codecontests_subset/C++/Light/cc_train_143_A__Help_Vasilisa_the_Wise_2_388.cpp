#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(0)->ios::sync_with_stdio(0);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int mas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  do {
    if (mas[0] + mas[1] == r1 && mas[2] + mas[3] == r2 &&
        mas[0] + mas[2] == c1 && mas[1] + mas[3] == c2 &&
        mas[0] + mas[3] == d1 && mas[1] + mas[2] == d2) {
      cout << mas[0] << ' ' << mas[1] << '\n';
      cout << mas[2] << ' ' << mas[3] << '\n';
      return 0;
    }
  } while (next_permutation(mas, mas + 9));
  cout << "-1\n";
  return 0;
}
