#include <bits/stdc++.h>
using namespace std;

int main() {
  int n;
  cin >> n;
  vector<int>table(n);

  for (int i = 0; i < n; i++) {
    cin >> table.at(i);
  }
  for (int i = 0; i < n-1; i++) {
    for (int j = i+1; j <n; j++) {
      if (abs(table.at(i)-table.at(j)) % (n-1) == 0) {
        cout << table.at(i) << " " << table.at(j);
        return 0;
      }
    }
  }
}



