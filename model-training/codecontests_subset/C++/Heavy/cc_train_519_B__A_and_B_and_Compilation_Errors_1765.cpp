#include <bits/stdc++.h>
using namespace std;
inline int get_Int() {
  int x;
  scanf("%d", &x);
  return x;
}
inline string get_String() {
  string x;
  cin >> x;
  return x;
}
map<int, bool> mark1, mark2, mark3;
int main() {
  int n;
  cin >> n;
  int list[3][n];
  for (int i = 0; i < n; i++) list[0][i] = get_Int();
  for (int i = 0; i < n - 1; i++) list[1][i] = get_Int();
  for (int i = 0; i < n - 2; i++) list[2][i] = get_Int();
  sort(list[0], list[0] + n);
  sort(list[1], list[1] + n - 1);
  sort(list[2], list[2] + n - 2);
  for (int i = 0; i < n - 1; i++) {
    if (list[0][i] != list[1][i]) {
      cout << list[0][i] << endl;
      break;
    }
    if (i == n - 2) {
      cout << list[0][n - 1] << endl;
      break;
    }
  }
  for (int i = 0; i < n - 2; i++) {
    if (list[1][i] != list[2][i]) {
      cout << list[1][i] << endl;
      break;
    } else if (i == n - 3) {
      cout << list[1][n - 2] << endl;
      break;
    }
  }
}
