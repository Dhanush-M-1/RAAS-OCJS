#include<iostream>
#include<string>

using namespace std;

int n;

void fun(int i,char c,string s){
    if(i>n) {
        cout<<s<<endl;
        return;
    }
    // if(i==1) printf("a");
    for(char ch='a';ch<=c;ch+=1) fun(i+1,c,s+ch);
    if(i>1) fun(i+1,c+1,s+=c+1);
}

int main(void)
{
    cin>>n;
    fun(1,'a',"");
    return 0;
}