#include <bits/stdc++.h>
using namespace std;
#define itn int
typedef long long ll;
int n;
void getans(string sn,char nw){
	if(sn.size()==n){
		cout<<sn<<'\n';
		return;
	}
	for(char nwi='a';nwi<nw;nwi++){
		getans(sn+nwi,nw);
	}
	getans(sn+nw,nw+1);
}
int main(){
	cin>>n;
	getans("",'a');
	return 0;
}
