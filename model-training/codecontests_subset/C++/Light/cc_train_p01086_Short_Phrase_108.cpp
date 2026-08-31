#include <iostream>
#include <vector>
#include <string>
using namespace std;

int len[5] = {5, 7, 5, 7, 7};

int main() {
  int N;
  while (cin >> N, N) {
	vector<string> a(N); for (int i = 0; i < N; ++i) cin >> a[i];
	for (int i = 0; i < N; ++i) {
	  bool ok = true;
	  int j = i;
	  for (int it = 0; it < 5; ++it) {
		string str = "";
		while (j < N && str.size() < len[it]) str += a[j++];
		if (str.size() != len[it]) {
		  ok = false;
		  break;
		}
	  }
	  if (ok) {
		cout << i+1 << endl;
		break;
	  }
	}
  }
}
		
		
		

