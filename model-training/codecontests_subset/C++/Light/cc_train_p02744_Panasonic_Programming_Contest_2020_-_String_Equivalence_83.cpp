#include<iostream>
using namespace std;
string s="a";
int n;
void dfs(int step,char $){
    if(step==n){
        cout<<s<<endl;
        return;
    }
    string t=s;
    char i;
    for(i='a';i<=$+1;i++){ 
    	s=t+i;
    	dfs(step+1,max($,i)); 
	}
	s=t; 
}
int main(){
    cin>>n;
    dfs(1,'a');
    return 0;
}