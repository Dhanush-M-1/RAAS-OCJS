#include <bits/stdc++.h>
using namespace std;
int main() {
  string line;
  int a;
  getline(cin, line);
  scanf("%d", &a);
  for (int i = 0; i < line.size(); i++) {
    if (line[i] >= 'A' && line[i] <= 'Z') line[i] += 32;
  }
  for (int i = 0; i < line.size(); i++) {
    if (line[i] < a + 97)
      line[i] = line[i] - 32;
    else
      continue;
  }
  cout << line << endl;
  return 0;
}
