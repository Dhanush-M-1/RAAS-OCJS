#include<iostream>
int main(){int n,m;std::cin>>n>>m;std::cout<<(n<0||n>9||m<0||m>9?-1:n*m);}