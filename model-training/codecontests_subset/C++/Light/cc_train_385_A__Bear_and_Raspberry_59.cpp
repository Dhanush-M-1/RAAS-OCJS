#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, max = 0;
  cin >> a >> b;
  int *mas = new int[a];
  cin >> mas[0];
  for (int i = 1; i < a; ++i) {
    cin >> mas[i];
    if (max < mas[i - 1] - mas[i] - b) {
      max = mas[i - 1] - mas[i] - b;
    }
  }
  cout << max << endl;
  delete[] mas;
}
