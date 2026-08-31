#include <iostream>
#include <string>
using namespace std;
int main(){
	int n;
	while(cin>>n){
		if(n==0) break;
		int a[n];
		for(int i=0;i<n;i++){
			string s;
			cin>>s;
			a[i]=s.size();
		}
		int st=0,t=0,ct=0;
		for(int i=0;i<n;i++){
			for(int j=i;j<n;j++){
				t=t+a[j];
				if(ct==0||ct==2){
					if(t>5){
						t=0;
						ct=0;
						break;
					}
					else if(t==5){
						t=0;
						ct++;
					}
				}
				else if(ct==1||ct==3||ct==4){
					if(t>7){
						t=0;
						ct=0;
						break;
					}
					else if(t==7){
						t=0;
						ct++;
					}
				}
			}
			if(ct==5){
				st=i+1;
				break;
			}
		}
		cout<<st<<endl;
	}
    return 0;
}