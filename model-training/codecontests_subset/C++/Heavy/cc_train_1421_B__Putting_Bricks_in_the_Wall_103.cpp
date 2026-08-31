#include <bits/stdc++.h>
using namespace std;
void edit(vector<int> &skill, int n) {
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    skill.push_back(x);
  }
}
void achilles() {
  int n;
  cin >> n;
  char arr[n][n];
  cin.ignore();
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> arr[i][j];
    }
    cin.ignore();
  }
  int a = arr[0][1] - '0';
  int b = arr[1][0] - '0';
  int c = arr[n - 2][n - 1] - '0';
  int d = arr[n - 1][n - 2] - '0';
  if ((a == b)) {
    if (c == d) {
      if (a == c) {
        cout << 2 << "\n";
        cout << n - 1 << " " << n << "\n" << n << " " << n - 1 << "\n";
        return;
      } else {
        cout << 0 << "\n";
        return;
      }
    } else {
      cout << 1 << "\n";
      if (c == a) {
        cout << n - 1 << " " << n << "\n";
        return;
      } else if (d == a) {
        cout << n << " " << n - 1 << "\n";
        return;
      }
    }
  } else if (c == d) {
    {
      cout << 1 << "\n";
      if (a == c) {
        cout << 1 << " " << 2 << "\n";
        return;
      } else if (b == c) {
        cout << 2 << " " << 1 << "\n";
        return;
      }
    }
  } else {
    cout << 2 << "\n";
    if (a == c) {
      cout << 2 << " " << 1 << "\n";
      cout << n - 1 << " " << n << "\n";
      return;
    } else {
      cout << 2 << " " << 1 << "\n";
      cout << n << " " << n - 1 << "\n";
      return;
    }
  }
}
int main() {
  ios ::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) achilles();
  return 0;
}
