#include <iostream>
#include <map>
using namespace std;
int n;
string s;
map<string,int> a;
const string x[]={"AC","WA","TLE","RE"};
int main(){
	cin>>n;
	while(n--){
		cin>>s;
		a[s]++;
	}
	for(int i=0;i<4;i++){
		cout<<x[i]<<" x "<<(a.count(x[i])?a[x[i]]:0)<<endl;
	}
	return 0;
}
