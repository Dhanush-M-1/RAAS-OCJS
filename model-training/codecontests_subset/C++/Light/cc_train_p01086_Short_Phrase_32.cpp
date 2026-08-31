#include <iostream>
using namespace std;
int main(){
  int n;
  while(cin >> n, n){
    string w[n];
    for(int i = 0; i < n; ++i){
      cin >> w[i];
    }
    int phrase[] = {5,7,5,7,7};
    bool f = false;
    for(int i = 0; i < n; ++i){
      if(f) break;
      int s = 0, t = 5;
      for(int j = i; j < n; ++j){
	t -= w[j].size();
	if(!t){
	  ++s;
	  if(s == 5){
	    cout << i+1 << endl;
	    f = true;
	    break;
	  }
	  t = phrase[s];
	}else if(t < 0) break;
      }
    }
  }
  return 0;
}