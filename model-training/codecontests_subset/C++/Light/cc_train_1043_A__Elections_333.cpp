#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, sum = 0;
  cin >> n;
  vector<int> v;
  while (n--) {
    int a;
    cin >> a;
    v.push_back(a);
    sum += a;
  }
  sort(v.begin(), v.end());
  int temp = v[v.size() - 1];
  bool done = false;
  while (!done) {
    int counter = 0;
    for (int i = 0; i < v.size(); i++) counter += (temp)-v[i];
    if (counter > sum)
      done = true;
    else
      temp++;
  }
  cout << temp;
  return 0;
}
