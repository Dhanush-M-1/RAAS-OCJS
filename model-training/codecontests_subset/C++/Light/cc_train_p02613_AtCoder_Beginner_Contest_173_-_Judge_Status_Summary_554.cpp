#include<iostream>
#include<map>
#include<string> 
using namespace std;
int main(){
	int N;
	cin>>N;
	map<string,int>rec;
	for(int i=0;i<N;++i){
		string a;
		cin>>a;
		++rec[a];
	}
	for(auto s:{"AC","WA","TLE","RE"}){
		cout<<s<<" x "<<rec[s]<<endl;
	}
	return 0;
}