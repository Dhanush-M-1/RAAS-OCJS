#include <iostream>
#include <string>
using namespace std;

int search(string s[]) {
  int count = 0;
  int t = 0;
  for (int i = 0; ; i++) {
    if (s[i].size() > 5) continue;
    int start = i;
    for (int j = i; ; j++) {
      t += s[j].size();
      if (count == 0 || count == 2) {
	if (t == 5) {
	  count++;
	  t = 0;
	} else if (t > 5) {
	  count = 0;
	  t = 0;
	  break;
	} 
      } else {
	if (t == 7) {
	  count++;
	  if (count == 5) return start;
	  t = 0;
	} else if (t > 7) {
	  count = 0;
	  t = 0;
	  break;
	}
      }
    }
  }
}


int main() {
  while (true) {
    int n;
    cin >> n;
    if (n == 0) return 0;

    string s[n];
    for (int i = 0; i < n; i++)
      cin >> s[i];
    
    int ans = search(s);
    cout << ans + 1 << endl;
  }
}