#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstring>
#include <string>
#include <cstdlib>
#include <sstream>
using namespace std;


int n;

string calc(string x){
	int Max=0;
	for(int i=1;i<x.size();i++){
		Max = max(Max, atoi(x.substr(0, i).c_str()) * atoi(x.substr(i).c_str()));
	}
	stringstream ss;
  	ss << Max;
  	return ss.str();
}
int main(){
	int i,j;
	string x;
	cin >> n;
	while(n--){
		int ans=0;
		cin >> x;
		for(;x.size()>1;ans++) x=calc(x);
		cout << ans << endl;
	}
	return 0;
}