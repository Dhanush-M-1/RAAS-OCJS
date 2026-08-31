#include <bits/stdc++.h>

using namespace std;

int main() {
  int N;
  
  while(cin >> N && N) {
    
    vector<int> vec(N);
    for(int i=0; i<N; i++) cin >> vec[i];
    
    int cnt = 0;
    for(int i=0; i<N; i++) {
      for(int j=0; j<N-i-1; j++) {
	if(vec[j] > vec[j+1]) {
	  cnt ++;
	  swap(vec[j], vec[j+1]);
	}
      }
    }
    
    cout << cnt << endl;
  }
  
  return 0;
}