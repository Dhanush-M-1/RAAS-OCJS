#include <bits/stdc++.h>
using namespace std;
int main() {
  int k = 0;
  int last;
  cin >> k;
  int *pos = new int[k * k];
  pos[0] = 0;
  for (int i = 1; i < k * k; i++) {
    last = pos[i - 1] + 1;
    if (((last) % 10) >= k)
      pos[i] = ((last) / 10 + 1) * 10 + ((last) % 10 - k);
    else
      pos[i] = last;
  }
  for (int i = 1; i < k; i++) {
    {
      for (int j = 1; j < k; j++) cout << pos[i * j] << " ";
    }
    cout << "\n";
  }
  return 0;
}
