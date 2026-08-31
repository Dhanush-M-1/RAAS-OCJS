#include <bits/stdc++.h>
using namespace std;
int main() {
  int size;
  string name1, name2, temp;
  vector<string> res;
  cin >> name1 >> name2 >> size;
  res.push_back(name1);
  res.push_back(name2);
  for (int i = 0; i < size; i++) {
    cin >> temp;
    if (temp == name1) {
      cin >> name1;
      res.push_back(name1);
      res.push_back(name2);
    } else {
      cin >> name2;
      res.push_back(name1);
      res.push_back(name2);
    }
  }
  for (int i = 0; i < res.size() - 1; i += 2) {
    cout << res[i] << " " << res[i + 1] << endl;
  }
  return 0;
}
