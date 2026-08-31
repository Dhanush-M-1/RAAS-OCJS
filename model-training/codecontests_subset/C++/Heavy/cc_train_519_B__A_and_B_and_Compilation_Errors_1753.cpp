#include <bits/stdc++.h>
using namespace std;
map<int, int> mymap1, mymap2, mymap3;
int main() {
  int n;
  scanf("%d", &n);
  int x;
  for (int i = 0; i < n; i++) {
    scanf("%d", &x);
    mymap1[x] += 1;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%d", &x);
    mymap2[x] += 1;
  }
  for (std::map<int, int>::iterator it = mymap1.begin(); it != mymap1.end();
       ++it) {
    if (mymap2.find(it->first) == mymap2.end() ||
        mymap2[it->first] < it->second) {
      cout << it->first << endl;
      break;
    }
  }
  for (int i = 0; i < n - 2; i++) {
    scanf("%d", &x);
    mymap3[x] += 1;
  }
  for (std::map<int, int>::iterator it = mymap2.begin(); it != mymap2.end();
       ++it) {
    if (mymap3.find(it->first) == mymap3.end() ||
        mymap3[it->first] < it->second) {
      cout << it->first << endl;
      break;
    }
  }
  return 0;
}
