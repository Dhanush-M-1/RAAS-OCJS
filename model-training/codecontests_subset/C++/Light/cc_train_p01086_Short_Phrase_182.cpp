#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(){
  while(true){
    int n;
    cin >> n;
    if(n == 0)
      break;

    vector<string> w(n);
    for(int i=0; i<n; i++)
      cin >> w[i];
         
    int tanku[5] = {5, 7, 5, 7, 7};
    bool judge = false;
    for(int i=0; i<n; i++){
      int place = i;
      for(int j=0; j<5; j++){
	int sum = 0;
	while(place <= n-1){
	  sum += w[place].size();
	  place++;
	  if(j == 4 && sum == tanku[j]){
	    cout << i+1 << endl;
	    judge = true;
	    break;
	  }
	  if(sum >= tanku[j])
	    break;
	}
	if(sum > tanku[j])
	  break;
      }
      if(judge == true)
	break;
    }
  }
  
  return 0;
}