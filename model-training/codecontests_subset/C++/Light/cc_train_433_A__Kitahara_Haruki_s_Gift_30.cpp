#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long n, a, s1, on = 0, tw = 0;
  cin >> n;
  float x;
  while (n--) {
    cin >> a;
    if (a == 100)
      on++;
    else
      tw++;
  }
  if (on == 0) {
    if (tw % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else if (tw == 0) {
    if (on % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  } else {
    s1 = (on * 100 + tw * 200) / 100;
    if (s1 % 2 == 0)
      cout << "YES";
    else
      cout << "NO";
  }
}
