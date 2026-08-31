#include<iostream>
#include<vector>
#include<string>
using namespace std;
int main(void){
int n;
int tanku[]={5,7,5,7,7};
while(1){
cin>>n;
if(n==0)break;
string a;
vector<int> w(n);
for(int i=0;i<n;i++){
	cin>>a;
	w[i]=a.size();
}
int plase;
for(int i=0;i<n;i++){
plase=i;
int sum=0;
int k=0;
bool flag=false;
for(int j=i;j<n;j++){
sum+=w[j];
if(sum>tanku[k])break;
if(sum==tanku[k]){
	k++;
	sum=0;
}
if(k==5){
	flag=true;
	break;
}
}
if(flag){
	cout<<i+1<<endl;
	break;
}
}
}	
return 0;
}